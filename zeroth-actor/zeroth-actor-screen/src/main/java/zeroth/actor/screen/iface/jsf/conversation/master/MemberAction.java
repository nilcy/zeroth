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
import com.kuzumeji.domain.actor.MemberFactory;
import com.kuzumeji.entity.actor.Member;
import com.kuzumeji.util.CodecHelper;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.actor.MemberServiceLocal;
/**
 * Member action.
 * @author nilcy
 */
@Named(value = "memberAction")
@ConversationScoped
public class MemberAction extends AbstractActionImpl<Member> {
    /** S/N. */
    private static final long serialVersionUID = 3945061120130283444L;
    /** member service Local-I/F. */
    @EJB
    private MemberServiceLocal service;
    /** temporary password. */
    private String tempPassword;
    /** Constructor. */
    public MemberAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Member> getService() {
        return this.service;
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
            c.setPassword(CodecHelper.sha256Hex(getTempPassword()));
        }
        return super.beforeSave();
    }
    /**
     * Get {@link #tempPassword}.
     * @return {@link #tempPassword}
     */
    public String getTempPassword() {
        return this.tempPassword;
    }
    /**
     * Set {@link #tempPassword}.
     * @param aTempPassword {@link #tempPassword}
     */
    public void setTempPassword(final String aTempPassword) {
        this.tempPassword = aTempPassword;
    }
}
