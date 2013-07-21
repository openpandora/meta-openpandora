require recipes-kernel/linux/linux.inc

DESCRIPTION = "Linux kernel for the OpenPandora handheld"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "openpandora"

# This is on the pandora-3.2 branch
SRCREV = "e353c52b9d4d1ecc5f9cc36dd78d7405c9cf2c48"

SRC_URI = " \
           git://git.openpandora.org/pandora-kernel.git;protocol=git;branch=pandora-3.2 \
"          
PV = "3.2.45-pandora+${PR}+git${SRCREV}"

S = "${WORKDIR}/git"

# NOTE: We pull in the default config from the OP kernel GIT tree and keep that config in sync the needs of OE in-tree.
# It does mean we do not ship the usual defconfig in the OE tree.

KERNEL_DEFCONFIG = "omap3_pandora_defconfig"

do_configure_prepend() {
	install -m 0644 ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig || die "No default configuration for ${MACHINE} / ${KERNEL_DEFCONFIG} available."
}
