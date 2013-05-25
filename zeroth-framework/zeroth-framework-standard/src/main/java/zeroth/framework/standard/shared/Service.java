// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.io.Serializable;
/**
 * サービスI/F
 * <ul>
 * <li>
 * EJBサービスはローカルI/F(@Local)を...Service、リモートI/F(@Remote)を...ServiceRemoteと命名すること。</li>
 * <li>EJBサービスの実装は原則ステートレスセッションBean(@Statless)として実装すること。</li>
 * <li>EJBサービスの実装は非CDIコンポーネント(@Alternative)として、EJBクライアントがCDIプロデューサ(@Produces)
 * を使用してCDIコンポーネント化すること。</li>
 * </ul>
 * @author nilcy
 */
public interface Service extends Serializable {
}
