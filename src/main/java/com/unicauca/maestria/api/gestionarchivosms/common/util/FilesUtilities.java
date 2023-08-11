package com.unicauca.maestria.api.gestionarchivosms.common.util;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class FilesUtilities {

    public static String guardarArchivo(String archivoBase64) {
        try {
            byte[] archivoBytes = Base64.getDecoder().decode(archivoBase64);
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yy");
            String fechaFormateada = formatoFecha.format(fechaActual);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(archivoBytes);

            Detector detector = new DefaultDetector();
            Metadata metadata = new Metadata();
            MediaType mediaType = detector.detect(TikaInputStream.get(inputStream), metadata);

            String nombreArchivo = mediaType.getType();
            String extension = detectExtension(inputStream);

            String rutaCarpeta = "./files/" + fechaFormateada;
            String rutaArchivo = rutaCarpeta + "/" + generateUniqueFileName() + "-" + nombreArchivo + extension;
            File carpeta = new File(rutaCarpeta);
            OutputStream out = null;
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    out = new FileOutputStream(rutaArchivo);
                    out.write(archivoBytes);
                    out.close();
                    return rutaArchivo;
                }
            } else {
                out = new FileOutputStream(rutaArchivo);
                out.write(archivoBytes);
                out.close();
                return rutaArchivo;
            }
            return "Error al guardar el archivo";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MimeTypeException e) {
            throw new RuntimeException(e);
        }
    }

    private static String detectExtension(ByteArrayInputStream inputStream) throws IOException, MimeTypeException {
        MimeTypes mimeTypes = MimeTypes.getDefaultMimeTypes();
        MediaType mimeType = mimeTypes.detect(inputStream, new Metadata());

        if (mimeType != null) {
            return mimeTypes.forName(String.valueOf(mimeType)).getExtension();
        }

        return "error";
    }

    private static String generateUniqueFileName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return timestamp;
    }

    public static boolean deleteFileExample(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                return true;
            }
        }
        return false;
    }
}
