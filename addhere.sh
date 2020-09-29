#!/bin/bash
NEW=output.sh
(
cat <<'Addition'
#!/bin/bash
echo "This script creates a new sh file"
a=10
b=50
((res=$a+$b))
echo " add is = $res"
Addition
) > $NEW

