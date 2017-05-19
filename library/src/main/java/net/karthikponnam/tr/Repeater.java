package net.karthikponnam.tr;

/**
 * Created by ponna on 19-05-2017.
 */

public class Repeater {

    public static String repeat(String data, int count) {
        String result = "";
        for(int i = 0; i < count; i++) {
            result += data;
        }
        return result;
    }

    public static String repeat(String data, int count, boolean spaces, boolean nextLine) {
        if(spaces && !nextLine) {
            String result = "";
            for(int i = 0; i < count; i++) {
                result += data + " ";
            }
            return result;
        } else if (!spaces && nextLine) {
            String result = "";
            for(int i = 0; i < count; i++) {
                result += data + "\n";
            }
            return result;
        } else if (spaces && nextLine) {
            String result = "";
            for(int i = 0; i < count; i++) {
                result += data + " " + "\n";
            }
            return result;
        } else {
            return repeat(data, count);
        }
    }

    public static String repeat(String data, int count, boolean spaces, boolean nextLine, boolean character, String character_text) {
        if(character) {
            if(spaces && !nextLine) {
                String result = "";
                for(int i = 0; i < count; i++) {
                    result += data + " " + character_text;
                }
                return result;
            } else if (!spaces && nextLine) {
                String result = "";
                for(int i = 0; i < count; i++) {
                    result += data + " " + character_text + "\n" ;
                }
                return result;
            } else if (spaces && nextLine) {
                String result = "";
                for(int i = 0; i < count; i++) {
                    result += data + " " + character_text + "\n";
                }
                return result;
            } else {
                return repeat(data + character_text, count);
            }
        } else {
            return repeat(data, count, spaces, nextLine);
        }
    }

    public static boolean checkText (String data) {
        if(data.trim().length() != 0) {
            return true;
        } else {
            return false;
        }
    }


}
