// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
/**
 * セキュリティユーティリティ
 * <dl>
 * <dt>事前条件</dt>
 * <dd>AES256bit鍵を利用するには、JCE管轄ポリシーファイル（無制限強度）をダウンロードして、
 * %JAVA_HOME%/jre/lib/securityへUS_export_policy.jarとlocal_policy.jar上書きすること。</dd>
 * </dl>
 * @author nilcy
 */
public class SecurityUtils {
    /** 暗号方式名 */
    private static final String ALGO_NAME = "AES";
    /** 乱数生成名 */
    private static final String RAND_NAME = "SHA1PRNG";
    /** 鍵長(標準128,JCE無制限ポリシー適用256) TODO 256bit鍵 */
    private static final int KEY_LENGTH = 128;
    /** 非公開コンストラクタ */
    private SecurityUtils() {
    }
    /**
     * 共通鍵の作成
     * <ul>
     * <li>AES256bit鍵を作成します。</li>
     * <li>SHA1PRNGで乱数生成したのち、URL安全なBASE64文字列に変換します。</li>
     * </ul>
     * @return 共通鍵(URL安全なBASE64文字列)
     */
    public static String createKey() {
        try {
            final KeyGenerator generator = KeyGenerator.getInstance(ALGO_NAME);
            generator.init(KEY_LENGTH, SecureRandom.getInstance(RAND_NAME));
            return Base64.encodeBase64URLSafeString(generator.generateKey().getEncoded());
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }
    /**
     * 暗号
     * @param plainBytes 平文バイト列
     * @param base64Key 共通鍵
     * @return 暗号バイト列
     */
    public static byte[] encrypt(final byte[] plainBytes, final String base64Key) {
        return exec(plainBytes, base64Key, Cipher.ENCRYPT_MODE);
    }
    /**
     * 復号
     * @param encryptedBytes 暗号バイト列
     * @param base64Key 共通鍵
     * @return 平文バイト列
     */
    public static byte[] decrypt(final byte[] encryptedBytes, final String base64Key) {
        return exec(encryptedBytes, base64Key, Cipher.DECRYPT_MODE);
    }
    /**
     * 暗号/復号実行
     * @param encryptedBytes 入力バイト列(平文/暗号)
     * @param base64Key 共通鍵
     * @param cipherMode 暗号/復号モード
     * @return 出力バイト列(暗号/平文)
     */
    private static byte[] exec(final byte[] encryptedBytes, final String base64Key,
        final int cipherMode) {
        try {
            final Cipher cipher = Cipher.getInstance(ALGO_NAME);
            cipher.init(cipherMode, new SecretKeySpec(Base64.decodeBase64(base64Key), ALGO_NAME));
            return cipher.doFinal(encryptedBytes);
        } catch (final InvalidKeyException e) {
            e.printStackTrace();
            throw new StandardRuntimeException(e);
        } catch (final NoSuchAlgorithmException e) {
            throw new StandardRuntimeException(e);
        } catch (final NoSuchPaddingException e) {
            throw new StandardRuntimeException(e);
        } catch (final IllegalBlockSizeException e) {
            throw new StandardRuntimeException(e);
        } catch (final BadPaddingException e) {
            throw new StandardRuntimeException(e);
        }
    }
}
