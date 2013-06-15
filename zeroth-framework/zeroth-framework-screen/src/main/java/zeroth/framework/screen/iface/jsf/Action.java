// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.io.Serializable;
import java.util.Collection;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.enterprise.shared.Persistable;
/**
 * JSFアクションI/F
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> 検索条件オブジェクト型 TODO extends ValueObject<?>
 * @author nilcy
 */
public interface Action<E extends Persistable<ID>, ID extends Serializable, F extends Serializable>
    extends Serializable {
    /**
     * エンティティ集合の取得
     * @return エンティティ集合
     */
    Collection<E> getItems();
    /**
     * 選択オブジェクトの取得
     * @return 選択オブジェクト
     */
    E getSelected();
    /** 画面の更新 */
    void refresh();
    /** 会話の開始 */
    void beginConversation();
    /** 会話の終了 */
    void endConversation();
    /**
     * 管理エンティティの確認
     * @return 管理エンティティか否か
     */
    boolean isManaged();
    /**
     * エンティティ保存
     * @return 遷移先
     */
    String save();
    /**
     * エンティティ削除
     * @return 遷移先
     */
    String delete();
    /**
     * キャンセル
     * @return 遷移先
     */
    String cancel();
    /**
     * ページ条件の取得
     * @return ページ条件
     */
    Pagination<E> getPagination();
    /**
     * 基本リポジトリサービスI/Fの取得
     * @return 基本リポジトリサービスI/F
     */
    SimpleRepositoryApplication<E, ID, F> getService();
    /**
     * 検索条件の取得
     * @return restriction
     */
    F getRestriction();
    /**
     * 識別子の取得
     * @return 識別子
     */
    ID getId();
    /**
     * 識別子の設定
     * @param aId 識別子
     */
    void setId(final ID aId);
    /**
     * 現在ページの取得
     * @return 現在ページ
     */
    int getPage();
    /**
     * 現在ページの設定
     * @param aPage 現在ページ
     */
    void setPage(final int aPage);
}
