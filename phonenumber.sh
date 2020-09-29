echo "enter filename"
read file
if [ -f $file ];
then
    grep -P '^(\d{3}-\d{3}-\d{4}|\d{3}\d{3}\d{4})$' <$file
else
    echo "$file does not exist"
fi
