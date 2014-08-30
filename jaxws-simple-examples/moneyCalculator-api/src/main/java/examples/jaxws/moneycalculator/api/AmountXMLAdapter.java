package examples.jaxws.moneycalculator.api;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AmountXMLAdapter extends XmlAdapter<String, Amount>{

    @Override
    public Amount unmarshal(String vt) throws Exception {
        return new Amount(vt);
    }

    @Override
    public String marshal(Amount bt) throws Exception {
        return bt.toString();
    }
    
}
