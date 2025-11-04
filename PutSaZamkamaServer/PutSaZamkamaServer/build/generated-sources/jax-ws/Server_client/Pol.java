
package Server_client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="pol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MUŠKI"/>
 *     &lt;enumeration value="ŽENSKI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "pol")
@XmlEnum
public enum Pol {

    MUŠKI,
    ŽENSKI;

    public String value() {
        return name();
    }

    public static Pol fromValue(String v) {
        return valueOf(v);
    }

}
