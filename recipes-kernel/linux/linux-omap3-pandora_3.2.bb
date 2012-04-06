require linux.inc

DESCRIPTION = "Linux kernel for the OpenPandora handheld"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap3-pandora"

# This is on the pandora-3.2 branch
SRCREV = "d15f95edd255c0366d6fb05f10e2a01898a580c3"

SRC_URI = " \
           git://git.openpandora.org/pandora-kernel.git;protocol=git;branch=pandora-3.2 \
"          

PV = "3.2.1-pandora+${PR}+git${SRCREV}"

S = "${WORKDIR}/git"

# NOTE: We pull in the default config from the OP kernel GIT tree and keep that config in sync the needs of OE in-tree.
# It does mean we do not ship the usual defconfig in the OE tree.

KERNEL_DEFCONFIG = "omap3_pandora_defconfig"

do_configure_prepend() {
	install -m 0644 ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig || die "No default configuration for ${MACHINE} / ${KERNEL_DEFCONFIG} available."
}
