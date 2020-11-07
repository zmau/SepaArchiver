package net.zmau;

import com.google.api.services.sheets.v4.Sheets;
import net.zmau.sepaarchive.DataItem;
import net.zmau.sepaarchive.HourDataItem;
import net.zmau.sepaarchive.SepaReader;
import net.zmau.sepaarchive.SheetWriter;

public class Main {
    private static Sheets sheetsService;

    public Main(){
        try {
            //SepaReader r = new SepaReader();
            //System.out.println(r.GetHtml());

            SheetWriter sheetsService = new SheetWriter();
            sheetsService.WriteItem(GetSampleItem());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private HourDataItem GetSampleItem(){
        HourDataItem item = new HourDataItem();
        item.setTime("06.11. 00h");
        item.setSO2("2");
        item.setPM10("10");
        item.setNO2("2");
        item.setCO("1");
        item.setPM2comma5("2.5");
        return item;
    }
    public static void main(String[] args) {
        try {
            Main m = new Main();
        }
        catch (Exception e){
            //System.out.println(e.Messa);
            e.printStackTrace();
        }
    }
}
