echo "Enter a file name"
read File
if [ -f $File ]
then
        echo " words are: $(cat $File | wc -w)"
        echo " Lines are: $(cat $File | wc -l)"
        echo " White spaces are: $(cat $File | grep -o " "| wc -l)"
        echo "Charcaters are: $(cat $File | wc -c)"
else
      echo "$file does not exists"
fi
