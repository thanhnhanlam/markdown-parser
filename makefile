test: MarkdownParse.class MarkdownParseTest.class
	java -cp ./:./lib/hamcrest-core-1.3.jar:./lib/junit-4.13.2.jar org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTest.class: MarkdownParse.class MarkdownParseTest.java
	javac -cp ./:./lib/hamcrest-core-1.3.jar:./lib/junit-4.13.2.jar MarkdownParseTest.java