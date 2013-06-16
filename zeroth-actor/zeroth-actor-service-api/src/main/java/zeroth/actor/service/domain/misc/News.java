// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * お知らせ
 * @author nilcy
 */
@Entity
@DiscriminatorValue("N")
@Cacheable(true)
@XmlRootElement
public class News extends Notice<News> {
    /** 製品番号 */
    private static final long serialVersionUID = 7736254990321896853L;
}
