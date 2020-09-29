export SSHPASS=Kapa@1998
sshpass -e sftp -oBatchMode=no -b - ka20118@192.168.1.199 <<EOF
ls
#mkdir aravindaftr
EOF
