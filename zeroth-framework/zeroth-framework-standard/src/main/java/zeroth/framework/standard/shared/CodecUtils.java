// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * コーデックのユーティリティ
 * @author nilcy
 */
public final class CodecUtils {
    /** 非公開コンストラクタ */
    private CodecUtils() {
    }
    /**
     * MD2ダイジェスト(HEX文字列)の計算
     * @param data 計算元の文字列
     * @return MD2ダイジェスト(HEX文字列)
     */
    public static String md2Hex(final String data) {
        return DigestUtils.md2Hex(data);
    }
    /**
     * MD5ダイジェスト(HEX文字列)の計算
     * @param data 計算元の文字列
     * @return MD5ダイジェスト(HEX文字列)
     */
    public static String md5Hex(final String data) {
        return DigestUtils.md5Hex(data);
    }
    /**
     * MD5ダイジェスト(HEX文字列)の計算
     * @param data 計算元の文字列
     * @return MD5ダイジェスト(HEX文字列)
     */
    public static String sha1Hex(final String data) {
        return DigestUtils.sha1Hex(data);
    }
    /**
     * SHA-256ダイジェスト(HEX文字列)の計算
     * @param data 計算元の文字列
     * @return SHA-256ダイジェスト(HEX文字列)
     */
    public static String sha256Hex(final String data) {
        return DigestUtils.sha256Hex(data);
    }
    /**
     * SHA-384ダイジェスト(HEX文字列)の計算
     * @param data 計算元の文字列
     * @return SHA-384ダイジェスト(HEX文字列)
     */
    public static String sha384Hex(final String data) {
        return DigestUtils.sha384Hex(data);
    }
    /**
     * SHA-512ダイジェスト(HEX文字列)の計算
     * @param data 計算元の文字列
     * @return SHA-512ダイジェスト(HEX文字列)
     */
    public static String sha512Hex(final String data) {
        return DigestUtils.sha512Hex(data);
    }
}
