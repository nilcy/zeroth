// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import zeroth.framework.standard.shared.MessageUtils;
/**
 * 追跡者の横断処理
 * @author nilcy
 */
@Interceptor
@Tracer
public class TracerInterceptor {
    /**
     * 追跡ログの出力
     * @param aContext 横断コンテキスト
     * @return 処理結果
     * @throws Exception 処理例外
     */
    @SuppressWarnings("static-method")
    @AroundInvoke
    public Object traceLog(final InvocationContext aContext) throws Exception {
        final Logger log = Logger.getLogger(aContext.getMethod().getDeclaringClass().toString());
        final String methodName = aContext.getMethod().getName();
        log.info(MessageUtils.build("Entering #{0} with {1}.", methodName, aContext.getParameters()));
        try {
            final Object result = aContext.proceed();
            log.info(MessageUtils.build("Exiting #{} with {}.", methodName, result));
            return result;
        } catch (final Exception e) {
            // OK to catch Exception here
            log.warning(e.getLocalizedMessage());
            throw e;
        }
    }
}
