package net.zmau.sepaarchive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class SheetWriter {
//https://www.baeldung.com/google-sheets-java-client
    private static final String APPLICATION_NAME = "SEPA Arhivar";
    private static String SPREADSHEET_ID = "1d-OPrhCoqKUSCu9wXbOIfWmcw-sFh1SWru26sJFQpZw";
    private static String API_KEY = "AIzaSyAGp4Y2SS9mLyTMZWrhZ4YGET-NgnUjDQw";
    private static Sheets sheetsService;

    public SheetWriter() throws IOException, GeneralSecurityException {
        sheetsService = getSheetsService();
    }
    public Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = GoogleAuthorizeUtil.authorize();

        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential   )
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public void WriteItem(DataItem item) throws IOException {
        ValueRange body = new ValueRange().setValues(Arrays.asList(
                Arrays.asList(/*item.getTime()*/"6.11", item.getSO2(), item.getPM10(), item.getNO2(), item.getCO(), item.getPM2comma5())
        ));

        AppendValuesResponse appendResult = sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID, "A1", body)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .execute();
    }
 }