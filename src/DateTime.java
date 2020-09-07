/*

    Author: Benjamin J. Dore
    Date:   9/4/2020

    Description:    DateTime class is used to define the date and time format that
                    will be printed on the customer's receipt

*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    // LocalDateTime object is created using the current date. The date is formatted in
    // Month-day-year and Hour:minute:second format
    private LocalDateTime myDateObj = LocalDateTime.now();
    private DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    private String formattedDate = myDateObj.format(myFormatObj);

    public String getDateAndTime() {
        return formattedDate;
    }

}
