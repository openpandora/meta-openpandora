SOC_FAMILY = "omap3"

require conf/machine/include/tune-cortexa8.inc

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

EXTRA_IMAGEDEPENDS += "u-boot x-load"
