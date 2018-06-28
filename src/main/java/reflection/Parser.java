package reflection;

import java.lang.reflect.Field;

public class Parser {

    public static String parseJSON(Object o) {
        StringBuilder sb = new StringBuilder();
        sb.append("[{");
        for (Field field : o.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                sb.append("\'").append(field.getName()).append("\':\'").append(field.get(o)).append("\',");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}]\n");
        return sb.toString();
    }

}
