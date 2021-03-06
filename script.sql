USE [master]
GO
/****** Object:  Database [QLNV]    Script Date: 04/17/2019 14:42:05 ******/
CREATE DATABASE [QLNV] ON  PRIMARY 
( NAME = N'QLNV', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\QLNV.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLNV_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\QLNV_log.LDF' , SIZE = 768KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLNV] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLNV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLNV] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [QLNV] SET ANSI_NULLS OFF
GO
ALTER DATABASE [QLNV] SET ANSI_PADDING OFF
GO
ALTER DATABASE [QLNV] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [QLNV] SET ARITHABORT OFF
GO
ALTER DATABASE [QLNV] SET AUTO_CLOSE ON
GO
ALTER DATABASE [QLNV] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [QLNV] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [QLNV] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [QLNV] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [QLNV] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [QLNV] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [QLNV] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [QLNV] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [QLNV] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [QLNV] SET  ENABLE_BROKER
GO
ALTER DATABASE [QLNV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [QLNV] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [QLNV] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [QLNV] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [QLNV] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [QLNV] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [QLNV] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [QLNV] SET  READ_WRITE
GO
ALTER DATABASE [QLNV] SET RECOVERY SIMPLE
GO
ALTER DATABASE [QLNV] SET  MULTI_USER
GO
ALTER DATABASE [QLNV] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [QLNV] SET DB_CHAINING OFF
GO
USE [QLNV]
GO
/****** Object:  Table [dbo].[Departs]    Script Date: 04/17/2019 14:42:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departs](
	[Id] [tinyint] IDENTITY(1,1) NOT NULL,
	[CodeId] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[CodeId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 04/17/2019 14:42:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Role] [bigint] NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Staffs]    Script Date: 04/17/2019 14:42:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staffs](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CodeId] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Gender] [bit] NOT NULL,
	[Photo] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Level] [tinyint] NOT NULL,
	[DepartId] [tinyint] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[CodeId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Records]    Script Date: 04/17/2019 14:42:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Records](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Type] [int] NOT NULL,
	[Reason] [nvarchar](200) NOT NULL,
	[Date] [date] NULL,
	[StaffId] [bigint] NOT NULL,
 CONSTRAINT [PK__Records__3214EC07108B795B] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Check [CK__Staffs__Level__1273C1CD]    Script Date: 04/17/2019 14:42:05 ******/
ALTER TABLE [dbo].[Staffs]  WITH CHECK ADD CHECK  (([Level]<=(10)))
GO
/****** Object:  ForeignKey [FK__Staffs__DepartId__1367E606]    Script Date: 04/17/2019 14:42:05 ******/
ALTER TABLE [dbo].[Staffs]  WITH CHECK ADD FOREIGN KEY([DepartId])
REFERENCES [dbo].[Departs] ([Id])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
/****** Object:  ForeignKey [FK__Records__StaffId__145C0A3F]    Script Date: 04/17/2019 14:42:05 ******/
ALTER TABLE [dbo].[Records]  WITH CHECK ADD  CONSTRAINT [FK__Records__StaffId__145C0A3F] FOREIGN KEY([StaffId])
REFERENCES [dbo].[Staffs] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Records] CHECK CONSTRAINT [FK__Records__StaffId__145C0A3F]
GO
