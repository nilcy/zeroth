// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.util.logging.Logger;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
/**
 * ロガーのファクトリ
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class LoggerProducer {
    /** コンストラクタ */
    private LoggerProducer() {
    }
    /**
     * ロガーの作成
     * @param aPoint 注入ポイント
     * @return ロガー
     */
    @Produces
    @Default
    private Logger createLogger(final InjectionPoint aPoint) {
        return Logger.getLogger(aPoint.getMember().getDeclaringClass().getName());
    }
}
