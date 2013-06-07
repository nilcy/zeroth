// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import zeroth.framework.enterprise.shared.EnterpriseBundle;
import zeroth.framework.enterprise.shared.EnterpriseException;
import zeroth.framework.standard.shared.StandardException;
/**
 * 制約違反キャッチ例外
 * @author nilcy
 */
public class ConstraintsException extends EnterpriseException {
    /** 識別番号 */
    private static final long serialVersionUID = 616063210164554646L;
    /**
     * コンストラクタ
     * @param key キー
     * @param values バリュー配列
     * @see StandardException#StandardException(String, Object...)
     */
    public ConstraintsException(final String key, final Object... values) {
        super(key, values);
    }
    /**
     * コンストラクタ
     * @param causeMap {@link EnterpriseException#getCauseMap()}
     */
    public ConstraintsException(final Map<String, Object[]> causeMap) {
        super(causeMap);
    }
    /** {@inheritDoc} */
    @Override
    public String getLocalizedMessage() {
        final Map<String, Object[]> causeMap = getCauseMap();
        final StrBuilder builder = new StrBuilder();
        for (final Entry<String, Object[]> entry : causeMap.entrySet()) {
            builder.appendln(EnterpriseBundle.formatMessage(entry.getKey(), entry.getValue()));
        }
        return StringUtils.chop(builder.toString());
    }
}
