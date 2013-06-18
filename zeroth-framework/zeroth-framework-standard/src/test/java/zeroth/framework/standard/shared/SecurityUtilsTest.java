// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import static org.junit.Assert.*;
import java.text.MessageFormat;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
/**
 * {@link SecurityUtils} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class SecurityUtilsTest {
    private static final Logger LOG = Logger.getAnonymousLogger();
    @Test
    public void testCreateKey() {
        final String key01 = SecurityUtils.createKey();
        final String key02 = SecurityUtils.createKey();
        assertTrue(key01 != key02);
        LOG.info(MessageFormat.format("共通鍵01={0},共通鍵02={1}", key01, key02));
    }
    @Test
    public void testEncryptDecrypt() {
        final String key = SecurityUtils.createKey();
        final String plainText = "極秘指令書その壱だお";
        final byte[] rawBytes = plainText.getBytes();
        final byte[] encBytes = SecurityUtils.encrypt(rawBytes, key);
        final byte[] decBytes = SecurityUtils.decrypt(encBytes, key);
        LOG.info(MessageFormat.format(
            "raw hex={0},encrypted hex={1},decrypted string={2}",
            new Object[] { Hex.encodeHexString(rawBytes), Hex.encodeHexString(encBytes),
                Hex.encodeHexString(decBytes) }));
        assertTrue(Hex.encodeHexString(rawBytes) != Hex.encodeHexString(encBytes));
        assertTrue(Hex.encodeHexString(encBytes) != Hex.encodeHexString(decBytes));
        assertEquals(Hex.encodeHexString(rawBytes), Hex.encodeHexString(decBytes));
        LOG.info(MessageFormat.format("raw string={0},decrypted string={1}", new String(rawBytes),
            new String(decBytes)));
        assertEquals(new String(rawBytes), new String(decBytes));
    }
}
