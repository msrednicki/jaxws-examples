package examples.jaxws.moneycalculator.api;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.LocalDate;

public class LocalDateXMLAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String string) throws Exception {
        return new LocalDate(string);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.toString();
    }
    
}