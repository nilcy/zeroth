// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.ws.calc;
/**
 * Calculator model factory.
 * @author nilcy
 */
public final class CalcFactory {
    /** コンストラクタ */
    private CalcFactory() {
        super();
    }
    /**
     * Create {@link CalcRequest}.
     * @param aParam1 1st parameter
     * @param aParam2 2nd parameter
     * @return {@link CalcRequest}
     */
    public static CalcRequest createCalcRequest(final long aParam1, final long aParam2) {
        final CalcRequest request = new CalcRequest();
        request.setParam1(aParam1);
        request.setParam2(aParam2);
        return request;
    }
    /**
     * Create {@link CalcResponse}.
     * @param aAnswer answer
     * @return {@link CalcResponse}
     */
    public static CalcResponse createCalcResponse(final long aAnswer) {
        final CalcResponse response = new CalcResponse();
        response.setAnswer(aAnswer);
        return response;
    }
}
