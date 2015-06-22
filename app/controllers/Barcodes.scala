package controllers

import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream

import org.krysalis.barcode4j.impl.upcean.EAN13Bean
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider
import play.api.mvc.{Action, Controller}

/**
 * Created by daniel.jodar on 22/06/2015.
 */
object Barcodes extends Controller {

  val ImageResolution = 144

  def ean13BarCode(ean: Long, mimeType: String): Array[Byte] = {
    val output: ByteArrayOutputStream = new ByteArrayOutputStream
    val canvas: BitmapCanvasProvider = new BitmapCanvasProvider(output, mimeType, ImageResolution, BufferedImage.TYPE_BYTE_BINARY, false, 0)
    val barCode = new EAN13Bean()
    barCode.generateBarcode(canvas, String valueOf ean)
    canvas.finish
    output.toByteArray
  }

  def barcode(ean: Long) = Action {
    import java.lang.IllegalArgumentException

    val MimeType = "image/png"
    try {
      val imageData = ean13BarCode(ean, MimeType)
      Ok(imageData).as(MimeType)
    } catch {
      case e: IllegalArgumentException => BadRequest("Couldn't generate bar code: " + e.getMessage)
    }
  }

}
