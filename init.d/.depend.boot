TARGETS = console-setup mountkernfs.sh resolvconf hostname.sh x11-common apparmor udev mountdevsubfs.sh procps networking hwclock.sh checkroot.sh urandom mountall-bootclean.sh mountall.sh bootmisc.sh kmod mountnfs-bootclean.sh mountnfs.sh checkfs.sh checkroot-bootclean.sh
INTERACTIVE = console-setup udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
procps: mountkernfs.sh udev
networking: mountkernfs.sh urandom resolvconf procps
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
urandom: hwclock.sh
mountall-bootclean.sh: mountall.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
bootmisc.sh: mountall-bootclean.sh udev mountnfs-bootclean.sh checkroot-bootclean.sh
kmod: checkroot.sh
mountnfs-bootclean.sh: mountnfs.sh
mountnfs.sh: networking
checkfs.sh: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
