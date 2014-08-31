JavaEE プロジェクトをgradleで管理するときの雛形にするつもりのやつ
# リポジトリ
- https://github.com/ntakeda67/javaee_gradle

# 前提
## 動作・開発環境
- JavaSE 7
- JavaEE 6
- JBoss EAP 6.2.0
- Netbeans 8
- Gradle 1.12

## やってること
- jUnitで書いたクラスのコンポーネントテスト(src/test)
- コンポーネントテスト実施時の、テスト結果・カバレッジレポート作成
- jUnit + Arquillianで書いた、APサーバ上での動作確認をするための統合テスト(src/integTest)。
  主にJAX-RSを叩いて、その戻りが想定通りかどうかの検査を役割とすることを想定。(参考. https://github.com/arquillian/arquillian-showcase/tree/master/jaxrs)
- 統合テスト実施時のテスト結果レポート作成

# 細かい調整してるところ
- jmockitをテスト実行時のクラスパスの先頭に持ってくるために、configurationsとsourceSetsを調整
- test実行時にjUnit4の@RunWith(Enclosed.class)で構成したテストが二度実行されることを回避(参考. http://d.hatena.ne.jp/shuji_w6e/20120808/1344386399)

# どうしようかと思ってるところ
- コンポーネントテストでDB状態の検査をする
- 統合テストの実行後のDB状態も検査したい。JAX-RSのエンドポイント移行に、@AsyncなEJBを呼ぶこともあるのでどうするか
- Jenkinsでwar作成とコンポーネントテストと統合テストをぐるぐるする