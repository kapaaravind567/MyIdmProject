echo "enter filename"
read file
if [ -f $file ]
then
    sed 's/[!@#\$%^&*(){}!;.><|]//g' <$file
else
    echo "$file does not exist"
fi


