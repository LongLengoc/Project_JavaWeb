USE [master]
GO


IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'Project_Banhang')
DROP DATABASE [Project_Banhang]
GO

USE [master]
GO


CREATE DATABASE [Project_Banhang] 
GO
USE [Project_Banhang]
GO

CREATE TABLE [dbo].[tblUser](
	[account] [nchar](10) NOT NULL,
	[pass] [nchar](10) NULL,
	[name] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[address] [nvarchar](50) NULL,
	[dateofbirth] [date] NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[tblMatHang](
	[MaHang] [varchar](10) NOT NULL,
	[Tenhang] [nvarchar](50) NOT NULL,
	[DVT] [varchar](50) NOT NULL,
	[Gia] [real] NULL,
	[Hinhanh] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblMatHang] PRIMARY KEY CLUSTERED 
(
	[MaHang] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


CREATE TABLE [dbo].[tblKhachHang](
	[MaKH] [varchar](10) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[GT] [bit] NOT NULL,
	[Diachi] [nvarchar](50) NULL,
	[NgaySinh] [datetime] NULL,
 CONSTRAINT [PK_tblKhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[tblHoadon](
	[MaHD] [numeric](18, 0) NOT NULL,
	[MaKH] [varchar](10) NOT NULL,
	[NgayHD] [datetime] NOT NULL,
 CONSTRAINT [PK_tblHoadon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]


CREATE TABLE [dbo].[tblChitietHD](
	[MaChiTietHD] [numeric](18, 0) NOT NULL,
	[MaHD] [numeric](18, 0) NOT NULL,
	[MaHang] [varchar](10) NOT NULL,
	[Soluong] [int] NOT NULL,
 CONSTRAINT [PK_tblChitietHD] PRIMARY KEY CLUSTERED 
(
	[MaChiTietHD] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO