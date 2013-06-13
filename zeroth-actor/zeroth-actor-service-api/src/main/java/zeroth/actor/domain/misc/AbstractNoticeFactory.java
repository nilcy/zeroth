// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.misc;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * Notice factory.
 * @param <T> notice type
 * @author nilcy
 */
public abstract class AbstractNoticeFactory<T extends Notice<T>> extends AbstractFactory<T> {
    /** コンストラクタ */
    public AbstractNoticeFactory() {
        super();
    }
}
