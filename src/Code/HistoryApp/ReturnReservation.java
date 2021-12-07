package Code.HistoryApp;

/*
This interface can be implemented of any class who need to add data in the file for another type of leased asset
without being modified.
 */
public interface ReturnReservation {
    void addLine(String format, String path);
}
