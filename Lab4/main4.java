import java.io.IOException;

class My_exception extends Exception {
    private int statusCode;

    public My_exception(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

class Exceptions {
    public static void main(String[] args) {
        try {
            Full_disk();
        } 
        catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            My_exception(404);
        } 
        catch (My_exception e) {
            if (e.getStatusCode() == 404) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        try {
            Null();
        } 
        catch (NullPointerException e) {
            System.out.println("Помилка: Об'єкт є null");
        }

        try {
            Division_by_zero();
        } 
        catch (ArithmeticException e) {
            System.out.println("Помилка: Ділення на нуль");
        } 
        finally {
            System.out.println("Сайт знайдено");
        }
    }

    static void Full_disk() throws IOException {
        throw new IOException("Диск заповнений");
    }

    static void My_exception(int statusCode) throws My_exception {
        throw new My_exception(statusCode, "Сторінка не знайдена");
    }

    static void Null() {
        Object obj = null;
        obj.toString();
    }

    static int Division_by_zero() {
        int result = 5 / 0;
        return result;
    }
}
