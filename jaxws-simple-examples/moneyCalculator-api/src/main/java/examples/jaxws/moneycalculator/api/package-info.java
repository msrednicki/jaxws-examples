@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type=LocalDate.class, value=LocalDateXMLAdapter.class),
    @XmlJavaTypeAdapter(type=Amount.class, value=AmountXMLAdapter.class),
})

@XmlAccessorType(XmlAccessType.FIELD)

package examples.jaxws.moneycalculator.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import org.joda.time.LocalDate;