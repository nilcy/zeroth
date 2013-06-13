// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.app;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import net.sf.json.JSONObject;
import zeroth.framework.standard.shared.StandardRuntimeException;
/**
 * ゲートウェイサービスのユーティリティ
 * @author nilcy
 */
public final class GatewayUtil {
    /** ロガー */
    private static final Logger LOG = Logger.getGlobal();
    /** 非公開コンストラクタ */
    private GatewayUtil() {
    }
    /**
     * ボディオブジェクトのJSONエンコード
     * @param <T> ボディオブジェクト型
     * @param body ボディオブジェクト
     * @return JSONエンコードしたボディオブジェクト
     */
    public static <T> String encode(final T body) {
        return JSONObject.fromObject(body).toString();
    }
    /**
     * ボディオブジェクトのJSONデコード
     * @param <T> ボディオブジェクト型
     * @param body ボディオブジェクト
     * @param beanClass JSONデコード変換先クラス
     * @return JSONデコード変換オブジェクト
     */
    public static <T> T decode(final String body, final Class<T> beanClass) {
        final JSONObject jsonObject = JSONObject.fromObject(body);
        return (T) JSONObject.toBean(jsonObject, beanClass);
    }
    /**
     * XMLマーシャル
     * @param model ゲートウェイオブジェクト
     * @return XMLマーシャルした文字列
     */
    public static String marshal(final GatewayModel model) {
        try {
            final JAXBContext context = JAXBContext.newInstance(GatewayModel.class);
            final JAXBElement<GatewayModel> element = new JAXBElement<>(new QName("submit"),
                GatewayModel.class, model);
            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // marshaller.marshal(element, System.out);
            final StringWriter writer = new StringWriter();
            marshaller.marshal(element, writer);
            return writer.toString();
        } catch (final JAXBException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * サービスプロキシの取得
     * @param <T> エンドポイントI/F型
     * @param wsdlLocation WSDLロケーション
     * @param namespaceURI ネームスペースURI
     * @param localPart ローカルパート
     * @param iface エンドポイントI/F
     * @return サービスプロキシ
     */
    public static <T> T getProxy(final String wsdlLocation, final String namespaceURI,
        final String localPart, final Class<T> iface) {
        try {
            final URL wsdlURL = new URL(wsdlLocation);
            final QName serviceName = new QName(namespaceURI, localPart);
            final Service service = Service.create(wsdlURL, serviceName);
            return service.getPort(iface);
        } catch (final MalformedURLException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * サービスプロキシの取得
     * @param <T> エンドポイントI/F型
     * @param iface エンドポイントI/F
     * @return サービスプロキシ
     */
    public static <T> T getProxy(final Class<T> iface) {
        try {
            final String baseName = iface.getPackage().getName() + ".soap";
            final ResourceBundle bundle = ResourceBundle.getBundle(baseName);
            final String wsdlLocation = bundle.getString("WsdlLocation");
            final String namespaceURI = bundle.getString("NamespaceURI");
            final String localPart = bundle.getString("LocalPart");
            LOG.info(MessageFormat.format("wsdlLocation={0}, namespaceURI={1}, localPart={2}",
                wsdlLocation, namespaceURI, localPart));
            return getProxy(wsdlLocation, namespaceURI, localPart, iface);
        } catch (final MissingResourceException e) {
            throw new StandardRuntimeException(e);
        }
    }
}
