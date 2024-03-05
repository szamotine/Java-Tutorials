package StudentDatabase;

public class StudentID {

    private String id;

    public void GenerateID(int year) {
        int idNumber = (int) (Math.random() * 10000);
        StringBuilder sb = new StringBuilder(String.valueOf(year));
        sb.append(String.format("%04d", idNumber));
        id = sb.toString();
    }

    public String getId() {
        return id;
    }
}
