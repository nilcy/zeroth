// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import zeroth.actor.app.actor.MemberServiceLocal;
import zeroth.actor.domain.Member;
import zeroth.actor.domain.MemberFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.standard.shared.CodecUtils;
/**
 * Member action.
 * @author nilcy
 */
@Named(value = "memberAction")
@ConversationScoped
public class MemberAction extends AbstractActionImpl<Member, Long, Member> {
    /** 製品番号 */
    private static final long serialVersionUID = 3945061120130283444L;
    /** member service Local-I/F. */
    @EJB
    private MemberServiceLocal service;
    /** temporary password. */
    private String tempPassword;
    /** コンストラクタ */
    public MemberAction() {
        super();
    }
    @Override
    public SimpleRepositoryApplication<Member, Long, Member> getService() {
        return service;
    }
    /**
     * {@inheritDoc}
     * @see MemberFactory#create()
     */
    @Override
    protected Member createInstance() {
        return new MemberFactory().create();
    }
    /** {@inheritDoc} */
    @Override
    protected boolean beforeSave() {
        final Member c = getSelected();
        if (StringUtils.isEmpty(c.getAddress().getName())) {
            c.getAddress().setName(c.getFamilyName());
        }
        if (StringUtils.isEmpty(c.getContact().getName())) {
            c.getContact().setName(c.getFamilyName());
        }
        if (StringUtils.isNotEmpty(getTempPassword())) {
            c.setPassword(CodecUtils.sha256Hex(getTempPassword()));
        }
        return super.beforeSave();
    }
    /**
     * {@link #tempPassword}.
     * @return {@link #tempPassword}
     */
    public String getTempPassword() {
        return tempPassword;
    }
    /**
     * {@link #tempPassword}.
     * @param aTempPassword {@link #tempPassword}
     */
    public void setTempPassword(final String aTempPassword) {
        tempPassword = aTempPassword;
    }
}
