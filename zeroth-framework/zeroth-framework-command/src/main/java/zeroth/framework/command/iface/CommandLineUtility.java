// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.command.iface;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
/**
 * コマンドラインユーティリティ
 * @author nilcy
 */
public final class CommandLineUtility {
    /** 非公開コンストラクタ */
    private CommandLineUtility() {
        super();
    }
    /**
     * コマンドライン引数のパース
     * @param aOptions 規定オプション
     * @param aArguments コマンドライン引数
     * @return コマンドライン
     * @throws ParseException コマンドラインのパース例外
     */
    public static CommandLine parse(final Options aOptions, final String[] aArguments)
        throws ParseException {
        return new PosixParser().parse(aOptions, aArguments);
    }
}
