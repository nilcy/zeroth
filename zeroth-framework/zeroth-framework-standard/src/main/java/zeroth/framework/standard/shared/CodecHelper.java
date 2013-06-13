// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * Codec helper.
 * @author nilcy
 */
public final class CodecHelper {
    /** Constructor. */
    private CodecHelper() {
    }
    /**
     * Calculates the SHA-256 digest and returns the value as a hex string.
     * @param aData data to Digest
     * @return SHA-256 digest as a hex string
     */
    public static String sha256Hex(final String aData) {
        return DigestUtils.sha256Hex(aData);
    }
}
