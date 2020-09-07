import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private LocalDateTime myDateObj = LocalDateTime.now();
    private DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    private String formattedDate = myDateObj.format(myFormatObj);

    public String getDateAndTime() {
        return formattedDate;
    }

}
