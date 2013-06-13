// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.apache.commons.lang3.Validate;
import zeroth.actor.domain.parts.OfficeAddress;
import zeroth.actor.domain.parts.OfficeAddressFactory;
/**
 * Office address action.
 * @author nilcy
 */
@Named("officeAddressAction")
@ApplicationScoped
@Singleton
// @Startup
public class OfficeAddressAction implements Serializable {
    /** S/N. */
    private static final long serialVersionUID = 2297830030681637217L;
    /** LEN_CODE. */
    private static final int LEN_CODE = 7;
    /** POS_CODE. */
    private static final int POS_CODE = 7;
    /** POS_PREF. */
    private static final int POS_PREF = 3;
    /** POS_TOWN. */
    private static final int POS_TOWN = 4;
    /** POS_CITY. */
    private static final int POS_CITY = 5;
    /** POS_STREET. */
    private static final int POS_STREET = 6;
    /** POS_NAME. */
    private static final int POS_NAME = 2;
    /** address map. */
    private Map<String, OfficeAddress> map;
    /** コンストラクタ */
    public OfficeAddressAction() {
        super();
    }
    /**
     * Process on post-construct.
     * @throws IOException IO Exception
     */
    @PostConstruct
    public void postConstruct() throws IOException {
        try (InputStream is = this.getClass().getResourceAsStream("/address/OfficeAddress.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "Windows-31J"))) {
            String line;
            map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                final String[] tmp = line.split(",");
                final String code = trimQuote(tmp[POS_CODE]);
                final String pref = trimQuote(tmp[POS_PREF]);
                final String town = trimQuote(tmp[POS_TOWN]);
                final String city = trimQuote(tmp[POS_CITY]);
                final String street = trimQuote(tmp[POS_STREET]);
                final String name = trimQuote(tmp[POS_NAME]);
                final OfficeAddress address = new OfficeAddressFactory().create(name, code, pref,
                    town, city, street);
                map.put(code, address);
            }
        }
    }
    /**
     * Trim item.
     * @param aItem item
     * @return trimmed item
     */
    private static String trimQuote(final String aItem) {
        return aItem.replaceAll("\"", "");
    }
    /**
     * Load office address.
     * @param aAddress office address
     * @return true if found
     */
    public boolean load(final OfficeAddress aAddress) {
        Validate.notNull(aAddress);
        final String key = aAddress.getCode().replaceAll("-", "");
        if (key.length() != LEN_CODE) {
            return false;
        }
        final OfficeAddress address = map.get(key);
        if (address != null) {
            aAddress.setPref(address.getPref());
            aAddress.setCity(address.getCity());
            aAddress.setTown(address.getTown());
            aAddress.setStreet(address.getStreet());
            aAddress.setName(address.getName());
        }
        return address != null;
    }
}
