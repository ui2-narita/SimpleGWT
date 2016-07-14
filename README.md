# SimpleGWT

- [x] _GWT_ のプロジェクトを gradle で管理したい
- [x] _GWT_ を _Super Dev Mode_ でデバッグしたい
- [x] _GWT_ を _REST_ で動かしたい
- [ ] _GWT_ のサーバーサイドを _Spring-boot_ で実装したい
- [ ] _heroku_ に簡単に deploy したい
- [ ] _GWT_ のコンパイル時、デバッグ時に lombok を使いたい

ということを目指してみます。

* _GWT_ はあくまでクライアントサイドの仕掛けが主なので、デバッグ観点もクライアントになるはず。
* プロジェクトに親子関係を持たせて、_Spring-boot_ のプロジェクトがこのプロジェクトを参照するようにするとうまくいくのではないか？
* jar パッケージには _client_, _shared_, _server_ が含まれているので、これらから _Spring-boot_ 側で _GWT_ をコンパイルし、出来上がった _js_ を _static_ フォルダに配置するとうまくいくのではないか？
* サーバーサイドの実装を _Spring-boot_ へのProxy として実装してしまえば、デバッグもサーバーサイドと結合した状態でできるかもしれない。 
* _GWT_ のコンパイル時に ```-javaagent:lombok.jar=ECJ``` がうまく動かない