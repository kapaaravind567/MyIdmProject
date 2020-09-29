echo "please enter tour name"
read name
echo "Hi $name, Lets start"

res=0
i="y"

echo " Enter First number."
read a 
echo "Enter second number"
read b
while [ $i = "y" ]
do
     echo "1.Add"
     echo "2.Sub"
     echo "3.Mul"
     echo "4.Div"
     echo "Enter your choice"
     read ch
     case $ch in
        1)res=`expr $a + $b`
          echo "Sum ="$res;;
        2)res=`expr $a - $b`
          echo "Sub = "$res;;
        3)res=`expr $a \* $b`
          echo "Mul = "$res;;
        4)res=`expr $a / $b`
          echo "Div = "$res;;
        *)echo "Invalid choice";;
     esac
     echo "Do u want to continue ?"
     read i
     if [ $i != "y" ]
     then
        exit
     fi
done    
