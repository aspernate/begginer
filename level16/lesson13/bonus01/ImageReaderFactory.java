package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by riabov on 30.05.16.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes type) throws IllegalArgumentException
    {
        if(type == ImageTypes.JPG){
            return new JpgReader();
        }
        else if(type == ImageTypes.PNG){
            return new PngReader();
        }
        else if(type == ImageTypes.BMP) {
            return new BmpReader();
        }
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
