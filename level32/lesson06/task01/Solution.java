package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        char[] pass;
        while(true) {
            pass = get8Random();

            boolean is = false;

            for(int i = 0; i < pass.length; i++) {
                if(pass[i] >= 48 && pass[i] <= 57)
                    is = true;
            }
            if(is == false) {
                continue;
            }

            is = false;
            for(int i = 0; i < pass.length; i++) {
                if(pass[i] >= 65 && pass[i] <= 90)
                    is = true;
            }
            if(is == false) {
                continue;
            }

            is = false;
            for(int i = 0; i < pass.length; i++) {
                if(pass[i] >= 97 && pass[i] <= 122)
                    is = true;
            }
            if(is == false) {
                continue;
            }
            else {
                break;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new String(pass).getBytes());
        } catch (IOException e) {}
        return byteArrayOutputStream;
    }

    private static char[] get8Random() {
        char[] pass = new char[8];
        for(int i = 0; i < pass.length; i++) {
            pass[i] = (char) getRandomSmbl();
        }
        return pass;
    }

    private static int getRandomSmbl() {
        int choose = (int) (Math.random() * 3);
        if(choose == 0) {
            return (int) (Math.random() * 10 + 48);
        } else if(choose == 1) {
            return (int) (Math.random() * 26 + 65);
        } else {
            return (int) (Math.random() * 26 + 97);
        }
    }
}
