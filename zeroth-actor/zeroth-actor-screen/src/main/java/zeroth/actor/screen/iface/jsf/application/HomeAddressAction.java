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
import zeroth.actor.domain.parts.Address;
import zeroth.actor.domain.parts.HomeAddress;
import zeroth.actor.domain.parts.HomeAddressFactory;
/**
 * Home address action.
 * @author nilcy
 */
@Named("homeAddressAction")
@ApplicationScoped
@Singleton
// @Startup
public class HomeAddressAction implements Serializable {
    /** S/N. */
    private static final long serialVersionUID = -4847634579319468521L;
    /** LEN_CODE. */
    private static final int LEN_CODE = 7;
    /** POS_CODE. */
    private static final int POS_CODE = 2;
    /** POS_PREF. */
    private static final int POS_PREF = 6;
    /** POS_TOWN. */
    private static final int POS_TOWN = 7;
    /** POS_CITY. */
    private static final int POS_CITY = 8;
    /** address map. */
    private Map<String, HomeAddress> map;
    /** コンストラクタ */
    public HomeAddressAction() {
        super();
    }
    /**
     * Process on post-construct.
     * @throws IOException IO Exception
     */
    @PostConstruct
    public void postConstruct() throws IOException {
        try (InputStream is = this.getClass().getResourceAsStream("/address/HomeAddress.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "Windows-31J"));) {
            String line;
            map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                final String[] tmp = line.split(",");
                final String code = trimQuote(tmp[POS_CODE]);
                final String pref = trimQuote(tmp[POS_PREF]);
                final String town = trimQuote(tmp[POS_TOWN]);
                final String city = trimQuote(tmp[POS_CITY]);
                final HomeAddress address = new HomeAddressFactory().create(code, pref, town, city);
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
     * Load home address.
     * @param aAddress home address
     * @return true if found
     */
    public boolean load(final Address<?> aAddress) {
        Validate.notNull(aAddress);
        final String key = aAddress.getCode().replaceAll("-", "");
        if (key.length() != LEN_CODE) {
            return false;
        }
        final HomeAddress address = map.get(key);
        if (address != null) {
            aAddress.setPref(address.getPref());
            aAddress.setCity(address.getCity());
            aAddress.setTown(address.getTown());
        }
        return address != null;
    }
}
