make MarkdownParse.class
for file in ./*.md
do
	echo $file
	java MarkdownParse $file
done

for file in test-files/*.md
do
	echo $file
	java MarkdownParse $file
done
