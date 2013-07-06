// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.messaging;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
/**
 * メッセージトピックサービス
 * @author nilcy
 */
@MessageDriven(mappedName = "jms/zeroth/primaryTopic", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class MessageTopicService implements MessageListener {
    /** コンストラクタ */
    public MessageTopicService() {
    }
    /** {@inheritDoc} */
    @Override
    public void onMessage(final Message message) {
        assert message != null;
    }
}
