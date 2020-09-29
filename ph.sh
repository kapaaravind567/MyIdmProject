if [ $# -lt 1 ]
then
 echo "Invaied no of arguments please pass one argument"
else
 FILE=$1
 LOF=`cat $FILE | wc -l`
fi
if [ $LOF -lt 1 ]
then
 exit
else
 while [ $LOF -ge 1 ]
 do
 read LINE
 #if [[ $LINE == '[0-9]\{10\}' | $LINE == '[0-9]\{3\}[-]\[0-9]\{3\}[-]\[0-9]\{4\}' ]]
 if [ $LINE == ('^(\d{3}-\d{3}-\d{4}|\d{3}\d{3}\d{4})$') ]
 #if [[ $LINE == [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9] ]]
 then
 echo "$LINE is valied"
 else
 echo "$LINE is in-valied"
 fi
 LOF=$(($LOF - 1))
 done < $FILE
fi
~/bin/bash: indent: command not found
